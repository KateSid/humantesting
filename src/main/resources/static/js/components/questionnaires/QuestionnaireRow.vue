<template>
    <div>
    <i>{{questionnaire.id }}</i> {{questionnaire.name}}
    <span style="position: absolute; right: 0">
        <input type="button" value="Edit" @click="edit"/>
        <input type="button" value="X" @click="del"/>
        </span>
    </div>
</template>

<script>
    export default {
        props: ['questionnaire','editQuestionnarie','deleteQuestionnarie','questionnaires'],
        methods: {
        edit() {
            this.editQuestionnarie(this.questionnaire);
        },
        del() {
          this.deleteQuestionnarie(this.questionnaire)
        }
    }
    }
</script>

<style>

</style>