
jQuery(document).ready(function() {
    
    $('fieldset:first-child').fadeIn('slow');

    //single step

    $('.stepfontactive').on('click', function() {
        var parent_fieldset = $(this).parents('fieldset');
        var fieldset_parentarea = parent_fieldset.parent();
        fieldset_parentarea.find("fieldset").each(function(fieldset){
            $(this).fadeOut();
        });
        parent_fieldset.fadeIn();
    });
    
    // next step
    $('.btn-next').on('click', function() {
    	var parent_fieldset = $(this).parents('fieldset');
    	var next_step = true;
    	
    	if( next_step ) {
    		parent_fieldset.fadeOut(400, function() {
	    		$(this).next().fadeIn();
	    	});
    	}
    	
    });
    
    // previous step
    $('.btn-previous').on('click', function() {
    	$(this).parents('fieldset').fadeOut(400, function() {
    		$(this).prev().fadeIn();
    	});
    });
    
});

function skip(num,e){
    var parent_fieldset = $(e).parents('fieldset');
    parent_fieldset.fadeOut(400,function(){
        var fieldset_parentarea = $(this).parent();
        fieldset_parentarea.find("fieldset").each(function(index,element){
            if (index == num) {
                $(this).fadeIn();
            }
        });
    });
}
    
