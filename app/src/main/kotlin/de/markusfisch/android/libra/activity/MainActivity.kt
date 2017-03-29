package de.markusfisch.android.libra.activity

import de.markusfisch.android.libra.app.setFragment
import de.markusfisch.android.libra.fragment.DecisionsFragment
import de.markusfisch.android.libra.R

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity(): AppCompatActivity() {
	override fun onSupportNavigateUp(): Boolean {
		val fm = getSupportFragmentManager()
		if (fm.getBackStackEntryCount() > 0) {
			fm.popBackStack()
		} else {
			finish()
		}
		return true
	}

	protected override fun onCreate(state: Bundle?) {
		super<AppCompatActivity>.onCreate(state)
		setContentView(R.layout.activity_main)
		initToolbar()

		if (state == null) {
			setFragment(getSupportFragmentManager(), DecisionsFragment())
		}
	}

	private fun initToolbar() {
		setSupportActionBar(toolbar)
		getSupportFragmentManager().addOnBackStackChangedListener {
			updateUpArrow()
		}
		updateUpArrow()
	}

	private fun updateUpArrow() {
		getSupportActionBar()?.setDisplayHomeAsUpEnabled(
				getSupportFragmentManager().getBackStackEntryCount() > 0)
	}
}