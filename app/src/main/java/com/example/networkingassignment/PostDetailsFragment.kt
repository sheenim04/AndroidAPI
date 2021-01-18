package com.example.networkingassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_post_details.*
import kotlinx.coroutines.*


class PostDetailsFragment : Fragment() {

    val scope = MainScope()
    val args: PostDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_post_details, container, false)

       // view.findViewById<TextView>(R.id.details_id).text = args.postId.toString()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scope.launch {
            try {
                loadData()
            }

            catch(e:Exception){
                Toast.makeText(
                    requireContext(),
                    "Exception occurred: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

    }

    suspend fun loadData(){
        val details = withContext(Dispatchers.IO){ getDetails()}
        setDetails(details)
        /*Toast.makeText(
            requireContext(),
            details.toString(),
            Toast.LENGTH_SHORT
        ).show()*/
    }

    private suspend fun getDetails(): Posts? {
        //delay(1000L)
        val response = ApiClient.client.getPost(args.postId)
        val data = response.body()

        if(response.isSuccessful && data != null){
            return data
        }
        else{
            throw Exception("Error")
        }
    }

    private fun setDetails(postDetails: Posts?){
        if(postDetails != null){
            details_userID.text = postDetails.userId.toString()
            details_id.text = postDetails.id.toString()
            details_title.text = postDetails.title
            details_body.text = postDetails.body
        }


    }
}