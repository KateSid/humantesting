<template>
    <div>
        <div v-if="!profile">Необходимо авторизоваться через<a href="/login">Google</a>
        </div>
        <div v-else>
            <div>
                {{profile.name}}&nbsp;<a href="/logout">Выйти</a>></div>
                <questionnaires-list :questionnaires="questionnaires"/>
        </div>
    </div>
</template>

<script>
    import QuestionnairesList from 'components/questionnaires/QuestionnaireList.vue'

    export default {
        components:{
            QuestionnairesList
        },
        data() {
            return {
                questionnaires: frontendData.questionnaires,
                profile: frontendData.profile
            }
        }
    };
</script>

<style>

</style>