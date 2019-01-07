package com.activityexample.activitycycle.ui.model

data class Movie (val page:Int,
                  val total_results:Int,
                  val total_pages:Int,
                  val results:List<Result> )