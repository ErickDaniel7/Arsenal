var stompClient = null;
var username = null;

document.getElementById("welcome-form").style.display = "block";

// Função para entrar na sala de chat
function enterChatRoom() {
    username = document.getElementById("username").value.trim();

    if (username) {
        document.getElementById("welcome-form").style.display = "none";
        document.getElementById("chat-room").style.display = "block";
        connect();
    } else {
        alert("Por favor, inserir um nickname");
    }
}

// Função para conectar ao WebSocket
function connect() {
    var socket = new SockJS('https://9e7df17fa210.ngrok.app/chat-websocket', {
        headers: {
            'ngrok-skip-browser-warning': 'true'
        }
    });
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Conectado: ' + frame);

        stompClient.subscribe('/topic/public', function (messageOutput) {
            showMessage(JSON.parse(messageOutput.body));
        });

        stompClient.send("/app/addUser", {}, JSON.stringify({
            sender: username,
            type: 'JOIN'
        }));
    }, function (error) {
        console.error('Erro de conexão: ' + error);
        alert('Não foi possível conectar ao servidor. Tente novamente mais tarde.');
    });
}

// Função para mostrar mensagens
function showMessage(message) {
    var messageElement = document.createElement('div');
    messageElement.classList.add(message.type.toLowerCase() + '-message'); // Adiciona uma classe baseada no tipo de mensagem

    if (message.type === 'JOIN') {
        messageElement.innerText = message.sender + " entrou na sala";
    } else if (message.type === 'LEAVE') {
        messageElement.innerText = message.sender + " saiu da sala";
    } else {
        messageElement.innerText = message.sender + " disse: " + message.content;
    }

    document.getElementById('messages').appendChild(messageElement);
    document.getElementById('messages').scrollTop = document.getElementById('messages').scrollHeight; // Rolagem automática
}

// Função para enviar mensagem
function sendMessage() {
    var messageContent = document.getElementById("messageInput").value.trim();

    if (messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageContent,
            type: 'CHAT'
        };
        stompClient.send('/app/sendMessage', {}, JSON.stringify(chatMessage));
        document.getElementById("messageInput").value = '';
    }
}

// Adiciona a funcionalidade de enviar mensagem com Enter
document.getElementById("messageInput").addEventListener("keypress", function (event) {
    if (event.key === "Enter") {
        event.preventDefault(); // Evita o comportamento padrão do Enter
        sendMessage();
    }
});

// Função para sair da sala
function leaveChat() {
    if (stompClient) {
        stompClient.send("/app/addUser", {}, JSON.stringify({
            sender: username,
            type: 'LEAVE'
        }));
        stompClient.disconnect(function () {
            console.log('Desconectado');
            document.getElementById("welcome-form").style.display = "block";
            document.getElementById("chat-room").style.display = "none";
        });
    }
}
