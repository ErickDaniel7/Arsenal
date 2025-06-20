document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'https://b3c5-177-91-39-198.ngrok-free.app/api/user'

    fetch(apiUrl, {
        headers: {
            'ngrok-skip-browser-warning': 'true'
        }
    })
    .then(response => {
        if(!response.ok){
            throw new Error('Erro ao buscar dados da API');
        }
        return response.json();
    })
    .then(data => {
        document.getElementById('name').textContent = data.name;
        document.getElementById('age').textContent = data.age;
        document.getElementById('about').textContent = data.aboutme;
    })
    .catch(error => console.error('Está errado'));
});
