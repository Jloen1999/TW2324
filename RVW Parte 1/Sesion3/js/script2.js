document.getElementById("demo").innerHTML = getRandomInt(0,100)

function getRandomInt(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}
