function getIndex(list, id) {
    for (var i=0; i < list.length; ++i){
        if (list[i].id === id){
            return i;
        }
    }
    return -1;
}

var questionnaireApi=Vue.resource('/questionnaire{/id}');

Vue.component('questionnaire-form',{
    props:['questionnaires','questionnaireAttr'],
    data: function () {
        return{
            name: '',
            id: ''
        }
    },
    watch: {
        questionnaireAttr: function(newVal, oldVal){
            this.name=newVal.name;
            this.id=newVal.id;
        }
    },
    template:
    '<div>'+
        '<input type="name" placeholder="Enter the name of the questionnaire" v-model="name"/>'+
        '<input type="button" value="Save" @click="save"/>'+
    '</div>',
    methods:{
        save: function () {
            var questionnaire={ name: this.name };

            if (this.id) {
                questionnaireApi.update({id: this.id}, questionnaire).then(result =>
                result.json().then(data => {
                    var index = getIndex(this.questionnaires, data.id);
                this.questionnaires.splice(index, 1, data);
                this.name = '';
                this.id = '';
            })
            )
            } else {
                questionnaireApi.save({}, questionnaire).then(result =>
                result.json().then(data => {
                    this.questionnaires.push(data);
                this.name = '';
            })
            )
            }
        }
    }
});

Vue.component('questionnaire-row', {
    props: ['questionnaire','editMethod','questionnaires'],
    template:
        '<div>' +
        '<i>{{questionnaire.id }}</i>{{questionnaire.name}}' +
        '<span style="position: absolute; right: 0">'+
        '<input type="button" value="Edit" @click="edit"/>'+
        '<input type="button" value="X" @click="del"/>'+
        '</span>'+
        '</div>',
    methods:{
        edit: function () {
            this.editMethod(this.questionnaire);
        },
        del: function () {
            questionnaireApi.remove({id: this.questionnaire.id}).then(result=>{
                if (result.ok){
                    this.questionnaires.splice(this.questionnaires.indexOf(this.questionnaire),1)
            }
            }
        )
        }
    }
});

Vue.component('questionnaires-list', {
    props: ['questionnaires'],
    data: function(){
        return {
            questionnaire: null
        }
    },
     template:
         '<div style="position: relative; width: 300px;">' +
         '<questionnaire-form :questionnaires="questionnaires" :questionnaireAttr="questionnaire"/>'+
         '<questionnaire-row v-for="questionnaire in questionnaires" ' +
         ':key="questionnaire.id" :questionnaire="questionnaire"' +
         ' :editMethod="editMethod" :questionnaires="questionnaires"/>' +
         '</div>',
    methods:{
        editMethod: function (questionnaire) {
            this.questionnaire=questionnaire;
        }
    }
});

var app = new Vue({
    el: '#app',
    template:
        '<div>'+
        '<div v-if="!profile">Необходимо авторизоваться через <a href="/login">Google</a></div>' +
        '<div v-else>'+
            '<div> {{profile.name}}&nbsp;<a href="/logout">Выйти</a>></div>' +
            '<questionnaires-list :questionnaires="questionnaires"/>'+
        '</div>'+
        '</div>',
    data: {
        questionnaires: frontendData.questionnaires,
        profile: frontendData.profile
    },
    created:function(){
      /*  questionnaireApi.get().then(result =>
        result.json().then(data =>
        data.forEach(questionnaire =>
        this.questionnaires.push(questionnaire))
            )
        )*/},
});