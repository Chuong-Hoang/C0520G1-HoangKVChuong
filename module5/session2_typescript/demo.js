function handleTimeout(timeout) {
    return new Promise(function (resolve, reject) {
        setTimeout(resolve, timeout);
    });
}
var xxx = handleTimeout(5000);
xxx.then(function () {
    console.log("LẬP");
})
    .then(function () {
    return handleTimeout(3000);
})
    .then(function () {
    console.log("TRÌNH");
})
    .then(function () {
    return handleTimeout(1000);
})
    .then(function () {
    console.log("JAVASCRIPT");
});
