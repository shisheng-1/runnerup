/*
 * Copyright (C) 2012 - 2013 jonas.oreland@gmail.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.runnerup.workout;

import java.util.HashMap;

public abstract class Trigger implements TickComponent {

	Feedback triggerAction[] = new Feedback[0];

	Scope scope = Scope.WORKOUT;

	@Override
	public void onInit(Workout s, HashMap<String, Object> bindValues) {
		for (Feedback f : triggerAction) {
			f.onInit(s, bindValues);
		}
	}

	@Override
	public void onEnd(Workout s) {
		for (Feedback f : triggerAction) {
			f.onEnd(s);
		}
	}

	public void fire(Workout s) {
		for (Feedback f : triggerAction) {
			s.addFeedback(f);
		}
	}
}
