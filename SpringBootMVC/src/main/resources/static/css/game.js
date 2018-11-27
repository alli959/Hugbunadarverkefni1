var selectedButton;
var shotButton;
var assistButton;
var reboundButton;
var homeScoreDiv;

var shotFrom; // Hvar leikmaður skaut
var playerId; // Leikmaðurinn sem er valin sem skýtur
var playerAssist; // Leikmaður sem gaf stoðsendingu
var playerRebound; // Leikmaður sem tekur frákast
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
       submitData(val);
       console.log('Made basket by player ' + playerId);
   } else { // Missed
       shotButton.classList.add('hidden'); // Felur takkan
       reboundButton.classList.remove('hidden');
       console.log('Missed basket by player ' + playerId);
   }
}

function submitData(data) {
    data.toString();
    var http = new XMLHttpRequest();
    http.responseType = 'json';

    http.open("POST", "/request", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    var params = "input=" + data;
    http.send(params);
    http.onload = function() {
        http.responseText;
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
    playerAssist = player;
    assistButton.classList.add('hidden'); // Felur takkan
    playerShoting.classList.remove('hidden');
    console.log('Assist by ' + player);
}

function rebound(player) {
    playerRebound = player;
    reboundButton.classList.add('hidden'); // Felur takkan
    console.log('Rebound for ' + player);
}

function shotPos(pos) {
    if(playerSelected) {
        shotButton.classList.remove('hidden'); // Birtir takkan
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "/game",
            data : JSON.stringify(pos),
            dataType : 'json',
            timeout : 100000,
            success : function(pos) {
                console.log("SUCCESS: ", pos);
                display(pos);
                alert(response);
            },
            error : function(e) {
                console.log("ERROR: ", e);
                display(e);
            },
            done : function(e) {
                console.log("DONE");
            }
        });
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
