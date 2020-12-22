import { Component} from '@angular/core';
import { FootballClubs } from './classes/FootballClubs';
import { FreeapiService } from './services/freeapi.service';
import {RandomMatches} from './classes/randomMatches';
import {SortByDate} from './classes/SortByDate';
import { MatchSimulation } from './classes/MatchSimulation';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  popUpRandomMatch = false;//random match popup set to false
  sortByDatePopUpBox = false;//sort date pop up set to false
  searchDatePopUpBox = false;//search date pop up set to false
  title = 'Premier League Manager';//title of the angular project

  footballClubs:FootballClubs[];//football club array 
  matchSimulation:MatchSimulation[];//matches played array
  randomMatches:RandomMatches[];//random match playing array
  sortByDateAscendingOrder:SortByDate[];//sort date in ascending order array

  //day,month and year which contain the user input values in the search field
  day:number;
  month:number;
  year:number;

  
//headings of the tables 
public headings_footballClub=["Club Name", "Country", "Location","No Of Matches Played", "Matches Won", "Matches Lost", "Matches Drawn", "Goals Scored", "Goals Received", "Points Scored","University Name","School Name","No Of Players"];
public headingSearch=["Home Team", "Opponent Team", "Date Of Match Played","Goals Scored Home Team", "Goals Scored Opponent Team"];
public headings_filterByDate=["Home Team", "Opponent Team", "Date Of Match Played","Goals Scored Home Team", "Goals Scored Opponent Team"];
public headingRandomMatch=["Home Team", "Opponent Team", "Date Of Match Played","Goals Scored Home Team", "Goals Scored Opponent Team"];

//clock and clock handle
clock=""
clockHandle;
  constructor(private _freeApiService:FreeapiService) { 
   
  }

  ngOnInit(){
    
    //get the football clubs from the http://localhost:9000
    this._freeApiService.getFootballClubs()
    .subscribe(
      data =>{
        this.footballClubs = data;

         }
    );  

    //get the football clubs from the http://localhost:9000/sortByDate
    this._freeApiService.getSortByDate()
    .subscribe(
      data =>{      
          this.sortByDateAscendingOrder = data;
            
      }      
    );

    //get the football clubs from the http://localhost:9000/matchesPlayed
    this._freeApiService.getMatchSimulation()
    .subscribe(
      data =>{      
          this.matchSimulation = data;          
      
      }      
    );    
   
  //https://stackblitz.com/edit/angular-clock-1-q2tuyq?file=src%2Fapp%2Fapp.component.html
   this.clockHandle = setInterval(()=>{
        this.clock = new Date().toLocaleString();},1000);
  }

//search field elements
dateFound=false;
alertBox=false;
homeTeam:string;
opponentTeam:string;
dateOfMatchPlayed:{day:number,month:number,year:number};
goalsScoredHomeTeam:number;
goalsScoredOpponentTeam:number;
tempSearchArray=new Array();

//search function
searchButton(){  

//empty the array in begining of each loop
this.tempSearchArray=[];
 
  //find if the date entered by the user is in the array
   for(let matchSimulationSearch of this.matchSimulation){
        if((this.day==matchSimulationSearch.dateOfMatchPlayed.day) && (this.month==matchSimulationSearch.dateOfMatchPlayed.month) && (this.year==matchSimulationSearch.dateOfMatchPlayed.year)){
          this.homeTeam=matchSimulationSearch.homeTeam;
          this.opponentTeam=matchSimulationSearch.opponentTeam;
          this.dateOfMatchPlayed={day: matchSimulationSearch.dateOfMatchPlayed.day,month:matchSimulationSearch.dateOfMatchPlayed.month,year:matchSimulationSearch.dateOfMatchPlayed.year}
          this.goalsScoredHomeTeam=matchSimulationSearch.goalsScoredHomeTeam;
          this.goalsScoredOpponentTeam=matchSimulationSearch.goalsScoredOpponentTeam;  
          //if the date is in the array displaying the modal
          this.searchDatePopUpBox=true;  
          //if the date is in the array making the datefound boolean value to true
          this.dateFound=true; 
          //if the date is in the array pushing the relavent information to the temporary array     
          this.tempSearchArray.push({homeTeam:matchSimulationSearch.homeTeam,opponentTeam:matchSimulationSearch.opponentTeam,dateMatchPlayed:matchSimulationSearch.dateOfMatchPlayed,goalsScoredHomeTeam:matchSimulationSearch.goalsScoredHomeTeam,goalsScoredOpponentTeam:matchSimulationSearch.goalsScoredOpponentTeam});
        }
    }
    
  //if the length of the temporary array is 0 making the day,month and year text filds to null and displaying an alert box
  if(this.tempSearchArray.length==0){
  for(let matchSimulationSearch of this.matchSimulation){
    //displaying an error message if one component of the date is found
    if((this.day==matchSimulationSearch.dateOfMatchPlayed.day) || (this.month==matchSimulationSearch.dateOfMatchPlayed.month) || (this.year==matchSimulationSearch.dateOfMatchPlayed.year)){
      this.day=null;
      this.month=null;
      this.year=null;
      alert("ERROR ! DATE CANNOT BE FOUND !!!");
      break;
    //displaying an error message if all the components of the date are not found
   }if(!((this.day==matchSimulationSearch.dateOfMatchPlayed.day) && (this.month==matchSimulationSearch.dateOfMatchPlayed.month) && (this.year==matchSimulationSearch.dateOfMatchPlayed.year))){
    this.day=null;
    this.month=null;
    this.year=null;
    alert("ERROR ! DATE CANNOT BE FOUND !!!");
     break;
   }
   break;
  }
}   
}

//close the filter by date modal after the button click
closePopUpFilterByDate(){
  this.searchDatePopUpBox=false;

}

  // sort wons in descending order
   compareWins(object1, object2, key){
    const obj1 = object1[key];
    const obj2 = object2[key];
  
    if (obj1 > obj2) {
      return -1
    }
    
    return 0
  }


  sortNoOfWins(){    
    this.footballClubs.sort((a,b)=>{
      return this.compareWins(a, b, 'matchesWon')    

    }
    )
  }



//sort goals scored in descending order
compareGoalsScored(object1, object2, key){
  const obj1 = object1[key];
  const obj2 = object2[key];

  if (obj1 > obj2) {
    return -1
  }
  
  return 0
}


sortGoalsScored(){

  this.footballClubs.sort((a,b)=>{
    return this.compareWins(a, b, 'goalsScored')   

  }
  )
}


comparedPointsScored(object1, object2, key){
  const obj1 = object1[key];
  const obj2 = object2[key];

  if (obj1 > obj2) {
    return -1
  }
  
  return 0
}


sortByPoints(){

  this.footballClubs.sort((a,b)=>{
    return this.compareWins(a, b, 'pointsScored')    

  }
  )
}


transform(elements:any[],searchTerm:String): Element[] {
  if(!elements || !searchTerm){
    return elements;
  }

  return elements.filter(element =>
    element.club.toLowerCase().indexOf(searchTerm.toLowerCase()) !==  -1);

}


homeTeamRandom:string;
opponentTeamRandom:string;
date:object;
goalsScoredHomeRandom:number;
goalsScoredOpponentRandom:number;
randomMatch(){   

  this._freeApiService.getRandomMatches()
  .subscribe(
    data =>{      
        this.randomMatches = data;
      
    }
    
  );

this.popUpRandomMatch=true;

}

homeTeamRandomMatchFound=false;
opponentTeamRandomMatchFound=false;
homeTeamRandomMatch:FootballClubs;
opponentTeamRandomMatch:FootballClubs;

closePopUpRandomMatch(){

  this.popUpRandomMatch=false;


for(let footballClubsRandomMatch of this.footballClubs){
  for(let matchSimulationRandomMatch of this.randomMatches){
 if(footballClubsRandomMatch.clubName.includes(matchSimulationRandomMatch.homeTeam)){
   this.homeTeamRandomMatchFound=true;
    this.homeTeamRandomMatch=footballClubsRandomMatch;

 }
 } 
}

for(let footballClubsRandomMatch of this.footballClubs){
  for(let matchSimulationRandomMatch of this.randomMatches){
 if(footballClubsRandomMatch.clubName.includes(matchSimulationRandomMatch.opponentTeam)){
   this.opponentTeamRandomMatchFound=true;
    this.opponentTeamRandomMatch=footballClubsRandomMatch;

 }
 } 
 }


if (this.homeTeamRandomMatchFound==true && this.opponentTeamRandomMatchFound==true){
    for(let matchSimulationRandomMatch of this.randomMatches){

      this.homeTeamRandomMatch.noOfMatchesPlayed=this.homeTeamRandomMatch.noOfMatchesPlayed+1;
      this.homeTeamRandomMatch.goalsScored=this.homeTeamRandomMatch.goalsScored+matchSimulationRandomMatch.goalsScoredHomeTeam;
      this.homeTeamRandomMatch.goalsReceived=this.homeTeamRandomMatch.goalsReceived+matchSimulationRandomMatch.goalsScoredOpponentTeam;
      
      this.opponentTeamRandomMatch.noOfMatchesPlayed=this.opponentTeamRandomMatch.noOfMatchesPlayed+1;
      this.opponentTeamRandomMatch.goalsScored=this.opponentTeamRandomMatch.goalsScored+matchSimulationRandomMatch.goalsScoredOpponentTeam;
      this.opponentTeamRandomMatch.goalsReceived=this.opponentTeamRandomMatch.goalsReceived+matchSimulationRandomMatch.goalsScoredHomeTeam;
  
    if(matchSimulationRandomMatch.goalsScoredHomeTeam > matchSimulationRandomMatch.goalsScoredOpponentTeam){
      this.homeTeamRandomMatch.pointsScored=this.homeTeamRandomMatch.pointsScored+3;
      this.homeTeamRandomMatch.matchesWon=this.homeTeamRandomMatch.matchesWon+1;
      this.opponentTeamRandomMatch.matchesLost=this.opponentTeamRandomMatch.matchesLost+1;

    }

    if(matchSimulationRandomMatch.goalsScoredHomeTeam < matchSimulationRandomMatch.goalsScoredOpponentTeam){
      this.opponentTeamRandomMatch.pointsScored=this.opponentTeamRandomMatch.pointsScored+3;
      this.opponentTeamRandomMatch.matchesWon=this.opponentTeamRandomMatch.matchesWon+1;
      this.homeTeamRandomMatch.matchesLost=this.homeTeamRandomMatch.matchesLost+1;
    }

    if(matchSimulationRandomMatch.goalsScoredHomeTeam == matchSimulationRandomMatch.goalsScoredOpponentTeam){
      this.homeTeamRandomMatch.pointsScored=this.homeTeamRandomMatch.pointsScored+1;
      this.opponentTeamRandomMatch.pointsScored=this.opponentTeamRandomMatch.pointsScored+1;

      this.homeTeamRandomMatch.matchesDrawn=this.homeTeamRandomMatch.matchesDrawn+1;
      this.opponentTeamRandomMatch.matchesDrawn=this.opponentTeamRandomMatch.matchesDrawn+1;

    }

}
}


for(let matchSimulationRandomMatch of this.randomMatches){
       this.matchSimulation.push({homeTeam:matchSimulationRandomMatch.homeTeam,opponentTeam:matchSimulationRandomMatch.opponentTeam,dateOfMatchPlayed:matchSimulationRandomMatch.dateOfMatchPlayed,goalsScoredHomeTeam:matchSimulationRandomMatch.goalsScoredHomeTeam,
        goalsScoredOpponentTeam:matchSimulationRandomMatch.goalsScoredOpponentTeam});
        
      }
  
      
for(let matchSimulationRandomMatch of this.randomMatches){
  this.sortByDateAscendingOrder.push({homeTeam:matchSimulationRandomMatch.homeTeam,opponentTeam:matchSimulationRandomMatch.opponentTeam,dateOfMatchPlayed:matchSimulationRandomMatch.dateOfMatchPlayed,goalsScoredHomeTeam:matchSimulationRandomMatch.goalsScoredHomeTeam,
   goalsScoredOpponentTeam:matchSimulationRandomMatch.goalsScoredOpponentTeam});
   
 }



}

sortByDate(){ 

    this.sortByDateAscendingOrder.sort((a, b) => (a.dateOfMatchPlayed.day < b.dateOfMatchPlayed.day ? -1 : 1));
    this.sortByDateAscendingOrder.sort((a, b) => (a.dateOfMatchPlayed.month < b.dateOfMatchPlayed.month ? -1 : 1));

  
  this.sortByDatePopUpBox=true;

  console.log(this.sortByDateAscendingOrder);
}


closePopUpsortByDate(){
  this.sortByDatePopUpBox=false;
}



}



