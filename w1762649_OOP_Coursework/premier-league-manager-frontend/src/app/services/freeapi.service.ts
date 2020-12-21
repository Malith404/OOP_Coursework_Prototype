import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
  export class FreeapiService {

  constructor(private httpclient:HttpClient) { }

   
  getFootballClubs():Observable<any>{
    return this.httpclient.get("http://localhost:9000");
  }

    getMatchSimulation():Observable<any>{
      return this.httpclient.get("http://localhost:9000/matchesPlayed");
  }

    getRandomMatches():Observable<any>{
      return this.httpclient.get("http://localhost:9000/randomMatch");
    }

    getSortByDate():Observable<any>{
      return this.httpclient.get("http://localhost:9000/sortByDate");
    }


}
