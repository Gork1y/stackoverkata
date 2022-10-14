const form = document.forms["newUserForm"];
form.addEventListener('submit', registrationNewUser)

async function registrationNewUser(e) {
    e.preventDefault();
    let response = await fetch("http://localhost:8080/api/user/registration/sendMessage", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            fullName: form.fullName.value,
            email: form.email.value,
            password: form.password.value,
        })
    })
    if (response.ok) {
        form.reset();
        alert('Проверь свою почту, сладкий');
    } else {
        form.reset();
        alert('Прости, но аккаунт с указанной почтой уже существует(');
    }
}