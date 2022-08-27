package com.example.finalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.finalapp.Adapter.GamesAdapter
import com.example.finalapp.data.Datasource

private lateinit var adapter:GamesAdapter
private lateinit var recyclerView : RecyclerView
class TournamentFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_tournament, container, false)
        val button=view.findViewById<Button>(R.id.book)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_tournamentFragment_to_ticketFragment)
        }//setOnClickListener
        // Inflate the layout for this fragment
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameData = Datasource().loadGames()
        recyclerView = view.findViewById(R.id.gamer)
        recyclerView.adapter = GamesAdapter(gameData)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=adapter


    }

}