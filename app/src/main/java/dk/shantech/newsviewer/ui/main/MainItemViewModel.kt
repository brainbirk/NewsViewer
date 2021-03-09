package dk.shantech.newsviewer.ui.main

import androidx.lifecycle.ViewModel

class MainItemViewModel() : ViewModel() {

//    <init {
//            val docRef = notification.stockSymbol?.let {
//                Firebase.firestore
//                        .collection("stockPrices")
//                        .document(it)
//            }
//            docRef?.addSnapshotListener { snapshot, e ->
//                if (e != null) {
//                    currentPrice.set("-")
//                    currentProfit.set(0.0)
//                    currentProfitFormatted.set("-")
//                    return@addSnapshotListener
//                }
//
//                if (snapshot != null && snapshot.exists()) {
//                    val currentMarketPrice = snapshot.getDouble("regularMarketPrice")
//                    if (currentMarketPrice != null) {
//                        currentPrice.set(currentMarketPrice.formatCurrencyWithTwoDecimals())
//                        val boughtPriceOld = notification.boughtPrice
//                        if (boughtPriceOld != null) {
//                            val profit = notification.calculateProfit(currentMarketPrice)
//                            currentProfit.set(profit)
//                            currentProfitFormatted.set(profit.formatPercentageWithTwoDecimals())
//                        }
//                    }
//                } else {
//                    currentPrice.set("-")
//                    currentProfit.set(0.0)
//                    currentProfitFormatted.set("-")
//                }
//            }
//    }
//
//    val risk = when(notification.risk) {
//        "l" -> R.mipmap.low_risk
//        "m" -> R.mipmap.medium_risk
//        "h" -> R.mipmap.high_risk
//        else -> R.mipmap.low_risk
//    }
//
//    val companyName = notification.stock
//
//    val boughtDate = notification.created?.toDate()?.formatToViewDate()
//
//    val boughtPrice = notification.boughtPrice?.formatCurrencyWithTwoDecimals()
//
//    val boughtCurrency = notification.stockCurrency
//
//    val percentageStake = notification.percentageStake?.formatCurrencyWithTwoDecimals()
//
//    val currentPrice = ObservableField<String>()
//    val currentProfit = ObservableDouble()
//    val currentProfitFormatted = ObservableField<String>()
}