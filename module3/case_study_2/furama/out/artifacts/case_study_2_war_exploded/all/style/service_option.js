
function getOption() {
    let option = document.getElementById("option").value;
    // alert("option value: " + option);
    if (option === "House") {
        document.getElementById("i-row").style.display = "none";

        document.getElementById("g-row").style.display = "table-row";
        document.getElementById("h-row").style.display = "table-row";
        document.getElementById("j-row").style.display = "table-row";
    } else if (option === "Room") {
        document.getElementById("g-row").style.display = "none";
        document.getElementById("h-row").style.display = "none";
        document.getElementById("i-row").style.display = "none";
        document.getElementById("j-row").style.display = "none";
    } else {
        document.getElementById("g-row").style.display = "table-row";
        document.getElementById("h-row").style.display = "table-row";
        document.getElementById("i-row").style.display = "table-row";
        document.getElementById("j-row").style.display = "table-row";
    }
}