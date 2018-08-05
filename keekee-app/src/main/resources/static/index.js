function connect() {
  var socket = new SockJS('/ws');
  var stompClient = Stomp.over(socket);
  stompClient.connect({}, function(frame) {
    stompClient.subscribe('/queue/notify', function(notification) {
      notify(JSON.parse(notification.body).content);
    });
  });
}

function initParticles() {
  Particles.init({
    selector: '.background',
    color: ['#008744', '#d62d20', '#ffa700'],
    connectParticles: true
  });
}

function notify(message) {
  $("#content").text(message);
}

$(document).ready(function() {
  connect();
  initParticles();
});