require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "iru-react-native-app-build-configurations"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.description  = <<-DESC
                  iru-react-native-app-build-configurations
                   DESC
  s.homepage     = "https://github.com/iruAiweapps/iru-react-native-app-build-configurations"
  s.license      = "MIT"
  # s.license    = { :type => "MIT", :file => "FILE_LICENSE" }
  s.authors      = { "Ilya" => "ilya.rysalovskiy@gmail.com" }
  s.platforms    = { :ios => "9.0", :tvos => "10.0" }
  s.source       = { :git => "https://github.com/iruAiweapps/iru-react-native-app-build-configurations.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m,swift}"
  s.requires_arc = true

  s.dependency "React"
	
  # s.dependency "..."
end

