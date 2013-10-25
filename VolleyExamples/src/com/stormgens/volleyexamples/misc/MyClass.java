/**
 * Copyright 2013 Ognyan Bankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stormgens.volleyexamples.misc;

import com.google.gson.annotations.SerializedName;

public class MyClass {
    @SerializedName("object_or_array")
    private String mType;
    
    @SerializedName("empty")
    private boolean mIsEmpty;
    
    @SerializedName("parse_time_nanoseconds")
    private long mNanoseconds;
    
    @SerializedName("validate")
    private boolean mIsValid;


    public String getType() {
        return mType;
    }


    public boolean isIsEmpty() {
        return mIsEmpty;
    }


    
    public long getmNanoseconds() {
		return mNanoseconds;
	}


	public void setmNanoseconds(long mNanoseconds) {
		this.mNanoseconds = mNanoseconds;
	}


	public long getNanoseconds() {
        return mNanoseconds;
    }


    public boolean isIsValid() {
        return mIsValid;
    }
}
