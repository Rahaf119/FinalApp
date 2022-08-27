package com.example.finalapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*


private const val PRICE_PER_TICKET = 65.00
class TicketViewModel:ViewModel() {

    val dateOptions = getPickupOptions()
    private val _quantity = MutableLiveData<Int>()
    val quantity : LiveData<Int> = _quantity

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price){
        NumberFormat.getCurrencyInstance().format(it)} //end price

    init { resetOrder() }//end init

    fun setQuantity(numberTickts: Int){
        _quantity.value = numberTickts
        updatePrice() }//end setQuantity


    // Date options + Date Formatting
    private fun getPickupOptions(): List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4){
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }//end repeat
        return options
    }//end getPickupOptions

    fun resetOrder() {
        _quantity.value = 0
        _date.value = dateOptions[0]
        _price.value = 0.0 }//end resetOrder


    // use VAT
    private fun updatePrice(){
        var calculatedPrice = (quantity.value ?: 0) * PRICE_PER_TICKET
        _price.value = calculatedPrice }//end updatePrice


}// end TeamViewModel