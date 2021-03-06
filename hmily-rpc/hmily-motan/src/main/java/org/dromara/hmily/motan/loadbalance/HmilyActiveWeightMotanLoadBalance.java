/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dromara.hmily.motan.loadbalance;

import com.weibo.api.motan.cluster.loadbalance.ActiveWeightLoadBalance;
import com.weibo.api.motan.cluster.loadbalance.RoundRobinLoadBalance;
import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.core.extension.Activation;
import com.weibo.api.motan.core.extension.SpiMeta;
import com.weibo.api.motan.rpc.Referer;
import com.weibo.api.motan.rpc.Request;
import java.util.List;

/**
 * The type Hmily active weight motan load balance.
 *
 * @param <T> the type parameter
 * @author xiaoyu(Myth)
 */
@SpiMeta(name = "hmilyActiveWeight")
@Activation(key = {MotanConstants.NODE_TYPE_REFERER})
public class HmilyActiveWeightMotanLoadBalance<T> extends ActiveWeightLoadBalance<T> {
    
    @Override
    protected Referer<T> doSelect(final Request request) {
        final Referer<T> defaultReferer = super.doSelect(request);
        return HmilyLoadBalanceUtils.doSelect(defaultReferer, getReferers());
    }

    @Override
    protected void doSelectToHolder(final Request request, final List<Referer<T>> refersHolder) {
        super.doSelectToHolder(request, refersHolder);
    }
}
