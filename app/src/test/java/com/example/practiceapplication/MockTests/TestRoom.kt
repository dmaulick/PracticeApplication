package com.example.practiceapplication.MockTests

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.platform.app.InstrumentationRegistry
import com.example.practiceapplication.Database.Drink
import com.example.practiceapplication.Database.DrinkDatabase
import junit.framework.Assert
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TestRoom {

    @Test
    fun test1() {
        runBlocking {
            CoroutineScope(Dispatchers.Default).launch {

                DrinkDatabase.TEST_MODE = true

                val context = InstrumentationRegistry.getInstrumentation().targetContext

                val db = DrinkDatabase.getInstance(context)

                val drinkDao = db.drinkDao()


                drinkDao.insertAll(Drink(1, "dI", "dn", "dc", true, "dinstruct"))

                drinkDao.insertAll(Drink(2, "2dI", "2dn", "2dc", false, "2dinstruct"))

                Assert.assertEquals(2, drinkDao.getAll().count())

                val c = drinkDao.findByName("2dn")


                Assert.assertEquals("2dI", c.drinkId)

                val d = drinkDao.loadAllByIds(arrayOf("dI", "2dI"))


                Assert.assertEquals(2, d.count())


                drinkDao.delete("2dI")
                Assert.assertEquals(1, drinkDao.getAll().count())
            }.join()
        }
    }
}