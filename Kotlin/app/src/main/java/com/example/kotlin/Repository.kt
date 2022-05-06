package com.example.kotlin

class Repository {
    interface IProductRepository {
        //傳入商品編號，取得商品資料
        fun getProduct(productId: String, loadProductCallback: LoadProductCallback)

        interface LoadProductCallback {
            //回傳商品資料Response
            fun onProductResult(productResponse:IProductRepository)
        }
    }
}