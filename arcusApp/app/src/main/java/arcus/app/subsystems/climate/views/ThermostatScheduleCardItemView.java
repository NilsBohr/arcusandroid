/*
 *  Copyright 2019 Arcus Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package arcus.app.subsystems.climate.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import arcus.cornea.subsystem.climate.model.ScheduledSetPoint;


public class ThermostatScheduleCardItemView extends BaseClimateScheduleCardItemView implements BaseClimateScheduleCardItemView.ClimateScheduleCardInterface {
    public ThermostatScheduleCardItemView(Context context) {
        super(context);
        setInterfaceListener(this);
    }

    public ThermostatScheduleCardItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setInterfaceListener(this);
    }

    public ThermostatScheduleCardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setInterfaceListener(this);
    }

    @Override
    public void updateRightText(TextView rightText, ScheduledSetPoint point) {
        switch (point.getMode()){
            case OFF:
                break;
            case HEAT:
                rightText.setText(String.valueOf(point.getHeatSetPoint()) + "º");
                break;
            case COOL:
                rightText.setText(String.valueOf(point.getCoolSetPoint()) + "º");
                break;
            case AUTO:
                rightText.setText(String.valueOf(point.getHeatSetPoint()) + "º-" + String.valueOf(point.getCoolSetPoint()) + "º");
                break;
        }
    }
}
