package com.nepxion.discovery.plugin.framework.event;

/**
 * <p>Title: Nepxion Discovery</p>
 * <p>Description: Nepxion Discovery</p>
 * <p>Copyright: Copyright (c) 2017-2050</p>
 * <p>Company: Nepxion</p>
 * @author Haojun Ren
 * @version 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;

public class PluginEventWapper {
    @Autowired
    private PluginPublisher pluginPublisher;

    @Autowired
    private PluginSubscriber pluginSubscriber;

    public void fireRuleUpdated(RuleUpdatedEvent ruleUpdatedEvent, boolean async) {
        if (async) {
            pluginPublisher.asyncPublish(ruleUpdatedEvent);
        } else {
            pluginSubscriber.onRuleUpdated(ruleUpdatedEvent);
        }
    }

    public void fireRuleCleared(RuleClearedEvent ruleClearedEvent, boolean async) {
        if (async) {
            pluginPublisher.asyncPublish(ruleClearedEvent);
        } else {
            pluginSubscriber.onRuleCleared(ruleClearedEvent);
        }
    }

    public void fireVersionUpdated(VersionUpdatedEvent versionUpdatedEvent, boolean async) {
        if (async) {
            pluginPublisher.asyncPublish(versionUpdatedEvent);
        } else {
            pluginSubscriber.onVersionUpdated(versionUpdatedEvent);
        }
    }

    public void fireVersionCleared(VersionClearedEvent versionClearedEvent, boolean async) {
        if (async) {
            pluginPublisher.asyncPublish(versionClearedEvent);
        } else {
            pluginSubscriber.onVersionCleared(versionClearedEvent);
        }
    }

    public void fireRegisterFailure(RegisterFailureEvent registerFailureEvent) {
        pluginPublisher.asyncPublish(registerFailureEvent);
    }
}