#import "AppBuildConfigurations.h"


@implementation AppBuildConfigurations

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport {
    return @{
        @"BuildType": NSBundle.mainBundle.infoDictionary[@"ConfigurationName"],
        @"isSimulator": @([self isSimulator])
    };
}

+ (BOOL)requiresMainQueueSetup {
    return NO; // UIKit not used
}

// MARK: - Helpers

- (BOOL)isSimulator {
    BOOL isSimulator = NO;
    #if TARGET_IPHONE_SIMULATOR
      isSimulator = YES;
    #endif
    return isSimulator;
}

@end
