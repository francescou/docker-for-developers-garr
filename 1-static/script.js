var app = angular.module('KnobDemoApp', ['ui.knob'])
app.controller('knobCtrl', function ($scope, $http) {

  $scope.$watch('thermostatValue', function (v, old) {
    if (old) {
      $http.post('api/thermostat', {value: v});
    }
  });

  $http.get('api/thermostat').success(function (data) {
    $scope.thermostatValue = data.value;
  });

  $http.get('api/humidity/').success(function (data) {
    $scope.humidityValue = data.value;
  });

  $http.get('api/temperature').success(function (data) {
    $scope.temperatureValue = data.value;
  });

  $scope.thermostatOptions = {
    displayPrevious: true,
    animate: {
      enabled: false
    },
    barCap: 25,
    trackWidth: 30,
    max: 30,
    barWidth: 20,
    barColor: 'rgba(64,220,178,.5)',
    trackColor: 'rgba(64,220,178,.1)',
    prevBarColor: 'rgba(0,0,0,.2)',
    textColor: 'rgba(64,220,178,.6)'
  };

  $scope.temperatureOptions = {
    displayPrevious: true,
    barCap: 25,
    animate: {
      enabled: false
    },
    trackWidth: 30,
    max: 30,
    barWidth: 20,
    readOnly: true,
    barColor: 'rgba(191,145,255,.5)',
    trackColor: 'rgba(191,145,255,.1)',
    prevBarColor: 'rgba(0,0,0,.2)',
    textColor: 'rgba(191,145,255,.6)'
  };


  $scope.humidityOptions = {
    displayPrevious: true,
    animate: {
      enabled: false
    },
    barCap: 25,
    trackWidth: 30,
    max: 100,
    barWidth: 20,
    readOnly: true,
    barColor: 'rgba(76,196,255,.5)',
    trackColor: 'rgba(76,196,255,.1)',
    prevBarColor: 'rgba(0,0,0,.2)',
    textColor: 'rgba(76,196,255,.6)'
  };


});
