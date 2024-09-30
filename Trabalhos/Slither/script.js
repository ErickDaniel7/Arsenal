const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');
canvas.width = window.innerWidth;
canvas.height = window.innerHeight;

let snake = [{ x: canvas.width / 2, y: canvas.height / 2 }];
let snakeLength = 10;
let speed = 2;
let direction = { x: 0, y: 0 };
let foods = [];
let bots = [];
const foodCount = 100;
const botCount = 5;

// Função para atualizar a posição do mouse
document.addEventListener('mousemove', (event) => {
    const angle = Math.atan2(event.clientY - snake[0].y, event.clientX - snake[0].x);
    direction = { x: Math.cos(angle) * speed, y: Math.sin(angle) * speed };
});

// Criar comidas aleatórias
for (let i = 0; i < foodCount; i++) {
    foods.push({
        x: Math.random() * canvas.width,
        y: Math.random() * canvas.height
    });
}

// Criar bots aleatórios
for (let i = 0; i < botCount; i++) {
    bots.push({
        body: [{ x: Math.random() * canvas.width, y: Math.random() * canvas.height }],
        direction: { x: Math.random() - 0.5, y: Math.random() - 0.5 },
        length: 10,
        color: `hsl(${Math.random() * 360}, 100%, 50%)`
    });
}

// Função principal do jogo
function gameLoop() {
    // Atualizar posição da cobra
    const head = { x: snake[0].x + direction.x, y: snake[0].y + direction.y };
    snake.unshift(head);

    if (snake.length > snakeLength) {
        snake.pop();
    }

    // Colisão com comida
    foods = foods.filter(food => {
        if (Math.hypot(food.x - head.x, food.y - head.y) < 10) {
            snakeLength++;
            return false;
        }
        return true;
    });

    // Atualizar bots
    bots.forEach(bot => {
        const botHead = bot.body[0];
        botHead.x += bot.direction.x * speed;
        botHead.y += bot.direction.y * speed;

        bot.body.unshift({ x: botHead.x, y: botHead.y });
        if (bot.body.length > bot.length) {
            bot.body.pop();
        }

        // Colisão dos bots com comida
        foods = foods.filter(food => {
            if (Math.hypot(food.x - botHead.x, food.y - botHead.y) < 10) {
                bot.length++;
                return false;
            }
            return true;
        });

        // Manter bots dentro dos limites
        if (botHead.x < 0 || botHead.x > canvas.width || botHead.y < 0 || botHead.y > canvas.height) {
            bot.direction.x *= -1;
            bot.direction.y *= -1;
        }
    });

    // Redesenhar tudo
    draw();
    requestAnimationFrame(gameLoop);
}

// Função para desenhar no canvas
function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Desenhar comidas
    foods.forEach(food => {
        ctx.fillStyle = 'red';
        ctx.beginPath();
        ctx.arc(food.x, food.y, 5, 0, Math.PI * 2);
        ctx.fill();
    });

    // Desenhar cobra do jogador
    ctx.fillStyle = 'lime';
    snake.forEach(segment => {
        ctx.beginPath();
        ctx.arc(segment.x, segment.y, 10, 0, Math.PI * 2);
        ctx.fill();
    });

    // Desenhar bots
    bots.forEach(bot => {
        ctx.fillStyle = bot.color;
        bot.body.forEach(segment => {
            ctx.beginPath();
            ctx.arc(segment.x, segment.y, 10, 0, Math.PI * 2);
            ctx.fill();
        });
    });
}

// Inicializar o jogo
gameLoop();
