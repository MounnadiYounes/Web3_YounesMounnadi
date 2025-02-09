// Password strength meter
const strength = {
    0: "worst",
    1: "bad",
    2: "weak",
    3: "good",
    4: "strong"
}

const password = document.getElementById("password")
const meter = document.getElementById("password-strength-meter")
const text = document.getElementById("password-strength-text")

if (password.value !== "") updatePasswordStrength()

password.addEventListener("input", updatePasswordStrength)

function updatePasswordStrength() {
    const val = password.value
    const result = zxcvbn(val)

    // Update the password strength meter
    meter.value = result.score

    // Update the text indicator
    if (val !== "") {
        text.innerHTML = strength[result.score]
    } else {
        text.innerHTML = "please enter a password"
    }
}