#import "AppBuildConfigurations.h"


@implementation AppBuildConfigurations

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport {
    return @{@"BuildType": NSBundle.mainBundle.infoDictionary[@"ConfigurationName"]};
}

+ (BOOL)requiresMainQueueSetup {
    return NO; // UIKit not used
}

@end
