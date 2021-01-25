 package com.example.networkingassignment.post.presentation

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_name.view.*
import com.airbnb.epoxy.EpoxyAttribute
import com.example.networkingassignment.post.R


@EpoxyModelClass
abstract class PostItemModel : EpoxyModelWithHolder<PostItemModel.ViewHolder>() {

    override fun getDefaultLayout(): Int {
        return R.layout.item_name
    }

  @EpoxyAttribute
    var userId : Int = 0

    @EpoxyAttribute
    var p_id : Int = 0

    @EpoxyAttribute
    lateinit var title: String

    @EpoxyAttribute
    lateinit var body: String

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var clickListener: View.OnClickListener? = null


    override fun bind(holder: ViewHolder) {
        super.bind(holder)

        holder.textUserID.text = "" + userId
        holder.textID.text =  "" + p_id
        holder.textTitle.text = title
        holder.textBody.text = body
        holder.cardView.setOnClickListener(clickListener)
    }

    override fun unbind(holder: ViewHolder) {
        super.unbind(holder)
        holder.cardView.setOnClickListener(null)
    }

    class ViewHolder : BaseEpoxyHolder() {
        lateinit var cardView: View
        lateinit var textUserID: TextView
        lateinit var textID : TextView
        lateinit var textTitle : TextView
        lateinit var textBody : TextView


        override fun bindView(itemView: View) {
            super.bindView(itemView)
            itemView.let {
                cardView = it.card
                textUserID = it.txt_userId
                textID = it.txt_id
                textTitle = it.txt_title
                textBody = it.txt_body
            }
        }
    }
}