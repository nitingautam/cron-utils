package com.cronutils.model.field;

/*
 * Copyright 2014 jmrozanec
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.cronutils.model.field.constraint.FieldConstraints;

/**
 * Represents every x time on a cron field.
 */
public class Every extends FieldExpression {
    private int time;

    public Every(FieldConstraints constraints, String time) {
        super(constraints);
        if (time == null) {
            time = "1";
        }
        constraints.validateAllCharsValid(time);
        this.time = getConstraints().stringToInt(time);
    }

    public int getTime() {
        return time;
    }

    @Override
    public String asString() {
        if(time==1){
            return "";
        }
        return String.format("/%s", getTime());
    }
}
