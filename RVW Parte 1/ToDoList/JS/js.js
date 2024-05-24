document.addEventListener('DOMContentLoaded', () => {
    const taskForm = document.getElementById('task-form');
    const taskInput = document.getElementById('task-input');
    const taskList = document.getElementById('task-list');
    const container2 = document.querySelector('.container2');

    // Función para mostrar container2 si hay tareas
    const showContainer2IfNeeded = () => {
        if (taskList.children.length > 0) {
            container2.style.display = 'block'; // Muestra el elemento
        } else {
            container2.style.display = 'none'; // Oculta el elemento
        }
    };

    // Cargar las tareas de "localStorage"
    const loadTasks = () => {
        const tasks = JSON.parse(localStorage.getItem('tasks')) || [];
        tasks.forEach(task => {
            addTaskToList(task.text, task.completed);
        });
        showContainer2IfNeeded();
    };

    // Añadir tareas a lista
    const addTaskToList = (text, completed = false) => {
        const li = document.createElement('li');
        const div = document.createElement('div');
        div.textContent = text;

        // Aplicar clase completed si la tarea está completada
        if (completed) {
            div.classList.add('completed');
        }

        const deleteBtn = document.createElement('button');
        deleteBtn.textContent = "Del";
        deleteBtn.classList.add('text-del-btn');
        deleteBtn.addEventListener('click', (event) => {
            event.stopPropagation(); // Evita que el evento de clic en el div se dispare
            taskList.removeChild(li);
            saveTasks();
            showContainer2IfNeeded(); // Verifica si se debe mostrar/ocultar container2
        });

        div.addEventListener('click', () => {
            div.classList.toggle('completed');
            saveTasks();
        });

        li.appendChild(div);
        li.appendChild(deleteBtn);
        taskList.appendChild(li);
        taskInput.value = '';
        saveTasks();
        showContainer2IfNeeded(); // Verifica si se debe mostrar/ocultar container2
    };

    // Guardar tareas a "localStorage"
    const saveTasks = () => {
        const tasks = [];
        taskList.querySelectorAll('li').forEach(li => {
            const div = li.querySelector('div');
            tasks.push({
                text: div.textContent,
                completed: div.classList.contains('completed')
            });
        });
        localStorage.setItem('tasks', JSON.stringify(tasks));
    };

    // Manejar el envío del formulario
    taskForm.addEventListener('submit', e => {
        e.preventDefault();
        const taskText = taskInput.value.trim();
        if (taskText !== '') {
            addTaskToList(taskText);
        }
    });

    // Inicializar la lista de tareas
    loadTasks();
});
