<template>
    <div style="position: relative; width: 300px;">
        <!--questionnarie-form :questionnaires="questionnaires" :questionnaireAttr="questionnaire"/>
        <questionnaire-row v-for="questionnaire in questionnaires"
                           :key="questionnaire.id"
                           :questionnaire="questionnaire"
                           :editQuestionnarie="editQuestionnarie"
                           :deleteQuestionnarie="deleteQuestionnarie"
                           :questionnaires="questionnaires"/-->
    </div>
</template>

<script>
   /* import QuestionnaireRow from 'components/questionnaires/QuestionnaireRow.vue'
    import QuestionnarieForm from 'components/questionnaires/QuestionnarieForm.vue'*/
    export default {
        props: ['questionnaires'],
       /* components:{
            QuestionnaireRow,
            QuestionnarieForm
        },*/
        data() {
            return {
                questionnaire: null
            }
        },
        methods: {
            editQuestionnarie(questionnaire) {
                this.questionnaire = questionnaire
            },
            deleteQuestionnarie(questionnaire){
                this.$resource('/questionnaire{/id}').remove({id: questionnaire.id}).then(result=>{
                    if (result.ok){
                        this.questionnaires.splice(this.questionnaires.indexOf(this.questionnaire),1)
                    }
                })
            }
        }
    }
</script>

<style>

</style>