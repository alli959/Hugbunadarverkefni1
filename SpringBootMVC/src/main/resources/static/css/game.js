var selectedButton;
var shotButton;
var assistButton;
var reboundButton;
var homeScoreDiv;

var shotFrom;
var playerId;
var playerShoting;

var scoreHome = 0;
var scoreAway = 0;

var playerSelected = false;

function shot(val) {
   if (val == 1) { // Made
       shotButton.classList.add('hidden'); // Felur takkan
       var allButtons = assistButton.querySelectorAll('.button');
       for (var i = 0; i < allButtons.length; i++) {
           var buttVal = allButtons[i].value;
           if (buttVal == playerId){
               playerShoting = allButtons[i];
               allButtons[i].classList.add('hidden'); // Getur ekki gefið stoðsendingu á sjálfan sig
           }
       }
       assistButton.classList.remove('hidden');
       addScore(shotFrom);
       console.log('Made basket by player ' + playerId);
   } else { // Missed
       shotButton.classList.add('hidden'); // Felur takkan
       reboundButton.classList.remove('hidden');
       console.log('Missed basket by player ' + playerId);
   }
}

function addScore(pos) {
    if (pos.includes('Three')) {
        scoreHome += 3;
        empty(homeScoreDiv);
        homeScoreDiv.appendChild(document.createTextNode(scoreHome));
        //Bæta við 3 stigum
    } else {
        scoreHome += 2;
        empty(homeScoreDiv);
        homeScoreDiv.appendChild(document.createTextNode(scoreHome));
        //Bæta við 2 stigum
    }
}

function assist(player) {
    assistButton.classList.add('hidden'); // Felur takkan
    playerShoting.classList.remove('hidden');
    console.log('Assist by ' + player);
}

function rebound(player) {
    reboundButton.classList.add('hidden'); // Felur takkan
    console.log('Rebound for ' + player);
}

function shotPos(pos) {
    if(playerSelected) {
        shotButton.classList.remove('hidden'); // Birtir takkan
    }
    shotFrom = pos;
}

function selectedPlayer(val){
    playerSelected = true;
    playerId = val;
}

document.addEventListener("DOMContentLoaded", function() {
    selectedButton = document.getElementsByClassName('funktradio-info');
    shotButton = document.querySelector('.game__shot');
    assistButton = document.querySelector('.game__assist');
    reboundButton = document.querySelector('.game__rebound');
    homeScoreDiv = document.querySelector('.home');
});
