function createRequest() {
    var request = false;

    if (window.XMLHttpRequest) {
        //Gecko-совместимые браузеры, Safari, Konqueror
        request = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        //Internet explorer
        try {
            request = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (CatchException) {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }

    if (!request) {
        alert("Невозможно создать XMLHttpRequest");
    }

    return request;
}

function sendPostRequest(path, args, handlerMethod) {
    var request = createRequest();
    if (!request) {
        return;
    }

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                handlerMethod(request);
            } else {
                alert("Ошибка при обработке запроса");
            }
        } else {
            //загрузка
        }
    };

    request.open("POST", path, true);
    // request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
    request.send(args);
}

function addNewText(story) {
    const template = document.querySelector('.template');
    const blank = document.querySelector('.blank');
    const eventClone = template.cloneNode(true);
    eventClone.classList.remove('template');
    eventClone.querySelector('.event__story').textContent = story;

    const parent = document.querySelector('.mainContainer');
    parent.insertBefore(eventClone, blank.nextSibling);
}

function handleKey(e) {
    if (e.keyCode === 13) {
        handleSend();
    }
}

function addNewTextByJson(request) {
    var responseData = eval("(" + request.responseText + ")");
    var story = responseData.story;

    addNewText(story)
}

function handleSend(){
    const inputField = document.querySelector("#mainInput");
    const command = inputField.value;
    if (command.trim() === ""){
        alert("Введите действие!");
        return;
    }
    inputField.value = "";
    var data = new FormData();
    data.append("command", command);
    sendPostRequest("/action", data, addNewTextByJson);
}