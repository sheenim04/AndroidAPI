 package com.example.networkingassignment

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import kotlinx.android.synthetic.main.item_name.view.*
import java.lang.Package.getPackage
import com.airbnb.epoxy.EpoxyAttribute

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.item_name)
abstract class NameItemModel : EpoxyModelWithHolder<NameItemModel.ViewHolder>() {


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