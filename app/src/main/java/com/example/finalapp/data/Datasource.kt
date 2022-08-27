package com.example.finalapp.data


import com.example.finalapp.R
import com.example.finalapp.model.Games

class Datasource() {
    fun loadGames():List<Games>{
        return listOf<Games>(
            Games(R.string.pubg,R.drawable.pubg_mobile),
            Games(R.string.rocketLeague,R.drawable.rocket_league),
            Games(R.string.fortnite,R.drawable.fortnite),
            Games(R.string.rainbow,R.drawable.rainbow_six),
            Games(R.string.dota_2,R.drawable.dota_2))//end list
    }//End fun
}// end class