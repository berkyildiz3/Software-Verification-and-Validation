var accounts = [
  {
    username: "123",
    password: "abc",
    name: "",
    age: "",
    gender: "",
    country: "",
    city: "",
    district: "",
    coughLevel: "",
    breathingLevel: "",
    bodyTemperature: "",
    chillsLevel: "",
    musclePainLevel: "",
    soreThroatLevel: "",
    lossOfTasteSmell: "",
  },
];

var username;
var password;

function getInfo(username, password) {
  username = document.getElementById("username").value;
  password = document.getElementById("password").value;

  if (username == "" && password == "") {
    alert("Username and password cannot be blank!");
    console.log(accounts);
    return "Username and password cannot be blank!";
  } else if (username == "" || password == "") {
    if (username == "") {
      alert("Username cannot be blank!");
      return "Username cannot be blank!";
    } else if (password == "") {
      alert("Password cannot be blank!");
      return "Password cannot be blank!";
    }
  }
  var found = false;
  for (i = 0; i < accounts.length; i++) {
    if (username == accounts[i].username && password == accounts[i].password) {
      found = true;
      if (found) {
        window.location.replace(
          "file:///C:/Users/BERKYILDIZ/Desktop/cs458/project4/covid/profile.html"
        );
      }
      console.log(accounts);
      return "Successful Login";
    }
  }
  if (!false) {
    alert("Username or password is wrong!");
    console.log(accounts);
    return "Username or password is wrong!";
  }
}

var usernameInput;
var passwordInput;

function signUp(usernameInput, passwordInput) {
  usernameInput = document.getElementById("usernameInput").value;
  passwordInput = document.getElementById("passwordInput").value;

  console.log(usernameInput);
  console.log(passwordInput);

  if (usernameInput == "" && passwordInput == "") {
    alert("Please enter username and password!");
    return "Please enter username and password!";
  } else if (usernameInput == "" || passwordInput == "") {
    if (usernameInput == "") {
      alert("Please enter username!");
      console.log(accounts);
      return "Please enter username!";
    } else if (passwordInput == "") {
      alert("Please enter password!");
      return "Please enter password!";
    }
  }

  var found1 = false;
  for (i = 0; i < accounts.length; i++) {
    if (usernameInput == accounts[i].username) {
      found1 = true;
      if (found1) {
        alert("Username exists. Please choose different one.");
        return "Username exists. Please choose different one.";
      }
      console.log(accounts);
      return "Username exists. Please choose different one.";
    }
  }
  if (!found1) {
    accounts.push({
      username: usernameInput,
      password: passwordInput,
      coughLevel: "",
      breathingLevel: "",
      bodyTemperature: "",
      chillsLevel: "",
      musclePainLevel: "",
      soreThroatLevel: "",
      lossOfTasteSmell: "",
    });
    console.log(accounts);
    alert("Account created. Please login from homepage.");
    return "Account created. Please login from homepage.";
  }

  console.log(accounts);
}

var fullName;
var age;
var gender;
var country;
var city;
var district;

function updateProfile(fullName, age, gender, country, city, district)
{
  fullName = document.getElementById("fullName").value;
  age = document.getElementById("age").value;
  gender = document.getElementById("gender").value;
  country = document.getElementById("country").value;
  city = document.getElementById("city").value;
  district = document.getElementById("district").value;

  if (
    fullName == "" ||
    age == "" ||
    gender == "" ||
    country == "" ||
    city == "" ||
    district == ""
  ) {
    alert("Please fill in all fields!");
    return "Please fill in all fields!";
  }else{
    for (i = 0; i < accounts.length; i++)
    {
      if(accounts[i].username == username)
      {
        accounts[i].fullName = fullName;
        accounts[i].age = age;
        accounts[i].gender = gender;
        accounts[i].country = country;
        accounts[i].city = city;
        accounts[i].district = district;

      }
    }


    alert("Your information has been saved.");
    return "Your information has been saved.";
  }
}

var breathingLevel;
var bodyTemperature;
var chillsLevel;
var musclePainLevel;
var soreThroatLevel;
var coughLevel;
var lossOfTasteSmell;

function checkStatus(
  breathingLevel,
  bodyTemperature,
  chillsLevel,
  musclePainLevel,
  soreThroatLevel,
  coughLevel,
  lossOfTasteSmell
) {
  breathingLevel = document.getElementById("difficultBreathing").value;
  bodyTemperature = document.getElementById("bodyTemperature").value;
  chillsLevel = document.getElementById("chillsInput").value;
  musclePainLevel = document.getElementById("musclePain").value;
  soreThroatLevel = document.getElementById("soreThroat").value;
  coughLevel = document.getElementById("coughInput").value;
  lossOfTasteSmell = document.getElementById("lossTasteSmell").value;

  for (i = 0; i < accounts.length; i++)
    {
      if(accounts[i].username == username)
      {
        accounts[i].breathingLevel = breathingLevel;
        accounts[i].bodyTemperature = bodyTemperature;
        accounts[i].chillsLevel = chillsLevel;
        accounts[i].musclePainLevel = musclePainLevel;
        accounts[i].soreThroatLevel = soreThroatLevel;
        accounts[i].coughLevel = coughLevel;
        accounts[i].lossOfTasteSmell = lossOfTasteSmell;

      }
    }

  if (
    breathingLevel == "" ||
    bodyTemperature == "" ||
    chillsLevel == "" ||
    musclePainLevel == "" ||
    soreThroatLevel == "" ||
    coughLevel == "" ||
    lossOfTasteSmell == ""
  ) {
    alert("Please fill in all fields!");
    return "Please fill in all fields!";
  } else {
    if (bodyTemperature < 30 || bodyTemperature > 45) {
      alert("You are already dead. Call funeral services!");
      return "You are already dead. Call funeral services!";
    } else if (bodyTemperature < 45 && bodyTemperature > 37.9) {
      alert("Visit the nearest hospital!");
      return "Visit the nearest hospital!";
    } else if (lossOfTasteSmell == "yes" || lossOfTasteSmell == "Yes") {
      alert("Visit the nearest hospital");
      return "Visit the nearest hospital";
    } else if (
      breathingLevel > 5 &&
      chillsLevel > 5 &&
      soreThroatLevel > 5 &&
      coughLevel > 5 &&
      musclePainLevel > 5
    ) {
      alert("Visit the nearest hospital");
      return "Visit the nearest hospital";
    } else if (
      breathingLevel < 2 &&
      chillsLevel < 2 &&
      soreThroatLevel < 2 &&
      coughLevel < 2 &&
      musclePainLevel < 2
    ) {
      alert("You look healthy. Be careful though. Stay at home.");
      return "You look healthy. Be careful though. Stay at home.";
    } else {
      alert("Watch your condition. Stay at home!");
      return "Watch your condition. Stay at home!";
    }
  }
}
