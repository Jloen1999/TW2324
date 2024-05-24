function showContent(section) {
    const content = document.getElementById('content');
    content.innerHTML = `<h1>${section}</h1><p>Contenido de la sección ${section}.</p>`;
}