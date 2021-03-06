'use strict';

angular.module('app.constants').constant('taskConstant', {
    
    typeOfJob : [
      {id: 1, name: 'Applications developer'},
      {id: 2, name: 'Database administrator'},
      {id: 3, name: 'Games developer'},
      {id: 4, name: 'IT consultant'},
      {id: 5, name: 'IT technical support officer'},
      {id: 6, name: 'Network engineer'},
      {id: 7, name: 'Software tester'},
      {id: 8, name: 'Web developer'}
    ],
    
    typeOfQuestion: [
      {id: 1, name: 'Applications'},
      {id: 2, name: 'Database'},
      {id: 3, name: 'Graphics'},
      {id: 4, name: 'Systems'}
    ],
    
    typeOfSpeak: [
      {id: 1, name: 'Face to face'},
      {id: 2, name: 'Call'},
      {id: 3, name: 'Writing'},
      {id: 4, name: 'Skype'}
    ]
    
});
