package com.example.fuze.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.fuze.R
import com.example.fuze.databinding.HomeItemAdpterBinding
import com.example.fuze.network.model.MatchesResponse
import com.example.fuze.util.Constants.CANCELED
import com.example.fuze.util.Constants.NOT_STARTED
import com.example.fuze.util.Constants.STARTED
import javax.inject.Inject

class HomeAdapter @Inject constructor() :
    PagingDataAdapter<MatchesResponse, HomeAdapter.MyViewHolder>(differCallback) {

    lateinit var binding: HomeItemAdpterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = HomeItemAdpterBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        getItem(position)?.let { holder.bind(it) }
    }

    inner class MyViewHolder(private val binding: HomeItemAdpterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(matches: MatchesResponse) {
            binding.apply {
                textLeagueSerie.text = "${matches.league.name} ${matches.serie_id}"
                //if game have only one match
                if (matches.games.size == 1) {
                    if (!matches.games[0].finished) {
                        when (matches.games[0].status) {
                            NOT_STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.not_started)
                            CANCELED -> hourText.text =
                                binding.root.resources.getString(R.string.canceled)
                            STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.now_playing)
                        }
                    } else {
                        hourText.text = binding.root.resources.getString(R.string.ended)
                    }
                    //if the game have 2 matches
                } else if (matches.games.size == 2) {
                    if (!matches.games[0].finished) {
                        when (matches.games[0].status) {
                            NOT_STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.not_started)
                            CANCELED -> hourText.text =
                                binding.root.resources.getString(R.string.canceled)
                            STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.now_playing)
                        }
                    } else {
                        if (matches.games[1].finished) {
                            hourText.text = binding.root.resources.getString(R.string.ended)
                        } else {
                            hourText.text = binding.root.resources.getString(R.string.now_playing)
                        }

                    }
                    //game have 3 matches
                } else {
                    if (!matches.games[0].finished) {
                        when (matches.games[0].status) {
                            NOT_STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.not_started)
                            CANCELED -> hourText.text =
                                binding.root.resources.getString(R.string.canceled)
                            STARTED -> hourText.text =
                                binding.root.resources.getString(R.string.now_playing)
                        }
                    } else {
                        if (matches.games[2].finished) {
                            hourText.text = binding.root.resources.getString(R.string.ended)
                        } else {
                            hourText.text = binding.root.resources.getString(R.string.now_playing)
                        }

                    }
                }

                matches.league.image_url?.let {
                    leagueImage.load(it) {
                        placeholder(R.drawable.team_logo)
                        scale(Scale.FILL)
                    }
                } ?: run {
                    leagueImage.load(R.drawable.team_logo) {
                        placeholder(R.drawable.team_logo)
                    }
                }

                if (matches.opponents.isNotEmpty()) {
                    firstOpponentName.text = matches.opponents[0].opponent.name
                    if (matches.opponents.size == 2) {
                        secondOpponentName.text = matches.opponents[1].opponent.name
                        matches.opponents[1].opponent.image_url?.let {
                            secondOpponent.load(it) {
                                placeholder(R.drawable.team_logo)
                            }
                        } ?: run {
                            secondOpponent.load(R.drawable.team_logo) {
                                placeholder(R.drawable.team_logo)
                            }
                        }
                    } else {
                        secondOpponent.load(R.drawable.team_logo) {
                            placeholder(R.drawable.team_logo)
                        }
                    }

                    matches.opponents[0].opponent.image_url?.let {
                        firstOpponent.load(it) {
                            placeholder(R.drawable.team_logo)
                            scale(Scale.FILL)
                        }
                    } ?: run {
                        firstOpponent.load(R.drawable.team_logo) {
                            placeholder(R.drawable.team_logo)
                        }
                    }
                } else {
                    firstOpponent.load(R.drawable.team_logo) {
                        placeholder(R.drawable.team_logo)
                    }
                    secondOpponent.load(R.drawable.team_logo) {
                        placeholder(R.drawable.team_logo)
                    }
                }

                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(matches)
                    }
                }
            }

        }
    }

    private var onItemClickListener: ((MatchesResponse) -> Unit)? = null

    fun setOnItemClickListener(listener: (MatchesResponse) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<MatchesResponse>() {
            override fun areItemsTheSame(
                oldItem: MatchesResponse,
                newItem: MatchesResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MatchesResponse,
                newItem: MatchesResponse
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}