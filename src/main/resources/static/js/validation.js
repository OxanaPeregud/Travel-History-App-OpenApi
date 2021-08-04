function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var country = document.journeyForm.country.value;
    var year = document.journeyForm.year.value;
    var description = document.journeyForm.description.value;
    var user = document.journeyForm.user.value;

    var countryErr = yearErr = userErr = true;

    if (country === "") {
        printError("countryErr", "Please enter country");
    } else {
        var regex1 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex1.test(country) === false) {
            printError("countryErr", "Please enter a valid country");
        } else {
            printError("countryErr", "");
            countryErr = false;
        }
    }

    if (year === "") {
        yearErr = false;
    } else {
        var regex2 = /^[0-9]+$/;
        if (regex2.test(year) === false) {
            printError("yearErr", "Please enter a valid year");
        } else {
            printError("yearErr", "");
            yearErr = false;
        }
    }

    if (user === "") {
        printError("userErr", "Please enter user");
    } else {
        var regex3 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex3.test(user) === false) {
            printError("userErr", "Please enter a valid user");
        } else {
            printError("userErr", "");
            userErr = false;
        }
    }

    if ((countryErr || yearErr || userErr) === true) {
        return false;
    } else {
        var dataPreview = "You've entered the following details: \n" +
            "Country: " + country + "\n" +
            "Year: " + year + "\n" +
            "Description: " + description + "\n" +
            "User: " + user;
        alert(dataPreview);
    }
}
