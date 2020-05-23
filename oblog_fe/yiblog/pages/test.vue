<template>
  <div>
    <!-- Default dropleft button -->
    <div class="btn-group dropleft">
      <button
        type="button"
        class="btn btn-secondary dropdown-toggle"
        data-toggle="dropdown"
        aria-haspopup="true"
        aria-expanded="false"
      >Dropleft</button>
      <div class="dropdown-menu">
        <!-- Dropdown menu links -->
      </div>
    </div>

    <!-- Split dropleft button -->
    <div class="btn-group">
      <div class="btn-group dropleft" role="group">
        <button
          type="button"
          class="btn btn-secondary dropdown-toggle dropdown-toggle-split"
          data-toggle="dropdown"
          aria-haspopup="true"
          aria-expanded="false"
        >
          <span class="sr-only">Toggle Dropleft</span>
        </button>
        <div class="dropdown-menu">
          <!-- Dropdown menu links -->
        </div>
      </div>
      <button type="button" class="btn btn-secondary">Split dropleft</button>
    </div>
  </div>
</template>

<script>
import $ from "jquery/dist/jquery.min.js";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";
export default {};
</script>
<style scoped lang="less">
</style>