let stls = document.createElement('text');
stls.innerHTML = "";

stls.type = 'text/css';
stls.innerHTML += `
    <link rel="stylesheet" type="text/css" href="https://cdn.sstatic.net/Shared/stacks.css?v=5ad0f45f4799">
    <link rel="stylesheet" type="text/css" href="https://cdn.sstatic.net/Sites/ru/primary.css?v=14a33b4ac9f9">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
`;

document.querySelector('head').insertAdjacentElement('afterbegin', stls);