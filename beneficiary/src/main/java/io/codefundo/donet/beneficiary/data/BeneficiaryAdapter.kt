package io.codefundo.donet.beneficiary.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import io.codefundo.donet.beneficiary.BeneficiaryActivity
import io.codefundo.donet.beneficiary.ListBeneficiariesActivity
import io.codefundo.donet.beneficiary.R
import io.codefundo.donet.core.Resource


class BeneficiaryAdapter(val activity: ListBeneficiariesActivity) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

    private val items = mutableListOf<Beneficiary>()

    fun updateUsers(resource: Resource) {
        when (resource) {
            is Resource.Success<*> -> {
                // Check if the list is a List<Beneficiary>
                val list = resource.data
                if (list is List<*>) {
                    // Filtering all objects in the list that are not of type Beneficiary
                    val listOfBeneficiaries: List<Beneficiary> = list.filterIsInstance<Beneficiary>()
                    if (listOfBeneficiaries.size == list.size) {
                        items.clear()
                        items.addAll(listOfBeneficiaries)
                        notifyDataSetChanged()
                    }
                }
            }

            is Resource.Failure -> {
                Toast.makeText(activity, resource.throwable.message, Toast.LENGTH_LONG).show()
            }

            is Resource.Loading -> {
                // TODO Handle loading
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beneficiary = items[position]
        holder.txtName.text = beneficiary.firstName
        holder.txtComment.text = beneficiary.lastName

        holder.itemView.setOnClickListener {
            val code = activity.intent.getStringExtra("code")
            val intent = Intent(activity, BeneficiaryActivity::class.java)
            intent.putExtra("id", position)
            intent.putExtra("code", code)
            activity.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.user_list_row, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val txtName: TextView = row.findViewById(R.id.txtName)
        val txtComment: TextView = row.findViewById(R.id.txtComment)
    }
}