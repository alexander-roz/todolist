const submitForm = document.querySelector(".add");
const addButton = document.querySelector(".add-todo");
const todoList = document.querySelector(".todos");
const list = document.querySelectorAll(".todos li");
const dayTitle = document.querySelector("#dayName");
const tasksList = document.querySelector("#tasks-list");
const lang = navigator.language;
const refreshButton = document.querySelector("#refresh-button");

let date = new Date();

let dayName = date.toLocaleString(lang, {
    weekday: "long"
});

dayTitle.innerHTML = dayName;

let listLength = list.length;

const generateTempalate = (todo) => {
    const html = `<li id = "${listLength}">
                  <input type="checkbox" id="todo_${listLength}">
                  <label for="todo_${listLength}">
                    <span class="check"></span>
                    ${todo}
                  </label>
                  <i class="far fa-trash-alt delete"></i>
                </li>`;
    todoList.innerHTML += html;
};

function addTodos(e) {
    e.preventDefault();
    const todo = submitForm.add.value.trim();

    if (todo.length) {
        listLength = listLength + 1;
        generateTempalate(todo);
        submitForm.reset();
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/tasks/");
    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log(xhr.status);
            console.log(xhr.responseText);
        }
    };

    let data = {
        "id": xhr.responseText,
        "taskName": todo,
    };
    xhr.send(JSON.stringify(data));
}

submitForm.addEventListener("submit", addTodos);
addButton.addEventListener("click", addTodos);

//delete {id} запрос работает
function deleteTodos(e) {
    if (e.target.classList.contains("delete")) {
        e.target.parentElement.remove();

        const id = e.target.parentElement.id;
        const xhr = new XMLHttpRequest();
        xhr.open("DELETE", '/tasks/' + id);
        xhr.send();
        console.log(id);
    }
}

tasksList.addEventListener("click", deleteTodos);

refreshButton.addEventListener("click", function (){
    window.location.reload();
});