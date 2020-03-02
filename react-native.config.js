module.exports = {
  dependency: {
    platforms: {
      android: {
        packageInstance: "new AppBuildConfigurationsPackage(BuildConfig.BUILD_TYPE, BuildConfig.FLAVOR)",
      },
    },
  },
};