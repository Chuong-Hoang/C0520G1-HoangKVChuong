
function getOption() {
    let option = document.getElementById("option").value;
    alert("option value: " + option);
    if (option === "House") {
        document.getElementById("i").setAttribute("type", "hidden");

        document.getElementById("g").setAttribute("type", "text");
        document.getElementById("h").setAttribute("type", "text");
        document.getElementById("j").setAttribute("type", "text");
    } else if (option === "Room") {
        document.getElementById("g").setAttribute("type", "hidden");
        document.getElementById("h").setAttribute("type", "hidden");
        document.getElementById("i").setAttribute("type", "hidden");
        document.getElementById("j").setAttribute("type", "hidden");
    } else {
        document.getElementById("g").setAttribute("type", "text");
        document.getElementById("h").setAttribute("type", "text");
        document.getElementById("i").setAttribute("type", "text");
        document.getElementById("j").setAttribute("type", "text");
    }
}