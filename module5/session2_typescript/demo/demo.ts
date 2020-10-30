let pro = new Promise(
    function (resolve, reject) {
        setTimeout(function(){
            console.log("Hello World");
        },9000);
    }
);

let connectDB = function (user, pass) {
    return new Promise(
        function (resolve, reject) {
            setTimeout(function () {
                if (user != "admin" || pass != "123") {
                    return reject("username or password not valid");
                } else {
                    return resolve("codegym.vn");
                }
            }, 4000);
        }
    )
};

let getData = function (url) {
    return new Promise(
        function (resolve, reject) {
            setTimeout(function () {
                if (url != "codegym.vn") {
                    return reject("URL is not valid, so there is no data.");
                } else {
                    return resolve("Connected successfully. Here is your data.");
                }
            }, 3000);
        }
    )
};

connectDB("admin", "123")
    .then(
        url => getData(url + "")
    )
    .then(
        data => console.log("DATA: " + data)
    )
    .catch(
        error => console.log("ERROR: " + error)
    );
